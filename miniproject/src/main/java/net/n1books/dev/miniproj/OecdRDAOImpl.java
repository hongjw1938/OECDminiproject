package net.n1books.dev.miniproj;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.stereotype.Repository;

@Repository(value="rConnection")
public class OecdRDAOImpl implements OecdRDAO{	
	private RConnection conn;
	private String Dataset_ID;
	private String[][] df_result;
	private RList all_Datasets;
	
	//private byte[] img_result = null;
	protected OecdRDAOImpl(){
		df_result = null;
		
		conn = getConnection();
		try {
			all_Datasets = conn.eval("df <- get_datasets();df").asList();
		} catch (RserveException e) {
			e.printStackTrace();
		} catch (REXPMismatchException e) {
			e.printStackTrace();
		}
	}
	
	private RConnection getConnection() {
		try {
			conn = new RConnection();
			conn.eval("library(OECD)");
			conn.eval("library(devtools)");
			conn.eval("library(ggplot2)");
		} catch (RserveException e) {
			System.out.println("R Studio가 켜져 있는지 확인하십시오.");
		}
		return conn;
	}
	
	//Eval로 받은 RList 객체를 String[][]으로 변환 시킴.
	public String[][] RListToStringArray(RList array) throws Exception {
		int cols = array.size();
		
		df_result = new String[cols][];
		for(int i=0; i < cols; i++) {
			df_result[i] = array.at(i).asStrings();
		}
		return df_result;
	}
	
	//전체 OECD 데이터 셋 종류 리턴
	@Override
	public String[][] getDatasets() throws Exception{
		
		return RListToStringArray(all_Datasets);
	}
	
	//특정 데이터 셋의 구조를 가져옴
	@Override
	public String[][] getSpecificSet(String id) throws Exception {
		System.out.println("DAOImpl 입니다.");
		System.out.println(id);
		Dataset_ID = id;
		conn.eval("dstruc <- get_data_structure(" + "\'" + id + "\'" + ")");
		conn.eval("structure <- as.data.frame(dstruc$VAR_DESC)");
		conn.eval("structure_cols <- colnames(dstruc$VAR_DESC)");
		//conn.eval("colNames <- colnames(structure)");
		
		
		RList desc_list = //conn.eval("structure").asList(); 
				conn.eval("rbinded <- rbind(structure_cols, structure); rbinded").asList();
		System.out.println("R에서 데이터를 가져오는데 성공했습니다.");
		
		return RListToStringArray(desc_list);
	}
	
	//특정 분류 기준의 세부 내용 가져옴
	@Override
	public String[][] getDetails(String id) throws Exception {
		conn.eval("detail <- dstruc$" + id);
		conn.eval("colNames <- colnames(dstruc$" + id + ")");
		RList detail_list = conn.eval("rbind(colNames, detail)").asList();
		
		System.out.println("R에서 데이터를 가져왔어요!");
		
		return RListToStringArray(detail_list);
	}
	
	@Override
	public String[][] getActualData(String query, String start_time, String end_time) throws Exception {
		query = query.replace(" ", "+");
		if(start_time.equals("null")) {
			start_time = "1900";
		}
		if(end_time.equals("null")) {
			end_time = "2018";
		}
		System.out.println(Dataset_ID);
		
		System.out.println(start_time);
		System.out.println(end_time);
		
		System.out.println(query);
		conn.eval("filter_list <- " + query);
		
		
		conn.eval("rawData <- get_dataset(\'" + Dataset_ID + "\' , filter = filter_list, start_time = \'" + start_time + "\', end_time = \'" + end_time + "\')");
		conn.eval("cols <- colnames(rawData)");
		RList dataList = conn.eval("rbind(cols, rawData)").asList();
		
		int cols = dataList.size();
		String retResult[][] = new String[cols][];
			
		for(int i=0; i < cols; i++) {		
			retResult[i] = dataList.at(i).asStrings();
		}
		return retResult;
	}
	
	



	@Override
	public String[][] search_Datasets(String subject) throws Exception {
		RList searched_list = 
				conn.eval("searched <- search_dataset(\'" + subject + "\'" + ", data=df); searched").asList();
		
		if(searched_list == null) {
			System.out.println("null임");
			throw new NullPointerException();
		}
		
		int cols = searched_list.size();
		df_result = new String[cols][];
		for(int i=0; i < cols; i++) {
			df_result[i] = searched_list.at(i).asStrings();
		}
		return df_result;
	}

	//실업률 시각화 자료 보여주는 메서드
	@Override
	public void getImg(String duration) throws Exception {
		if(duration.equals("\'null\'")) {
			duration = "UN5";
		}
		System.out.println(duration);
		//byte retImg[] = null;
		//conn.eval("jpeg('C:/dev64/temp/data.jpg')");
		conn.eval("rawData_plot <- rawData[rawData$DURATION == \'" + duration + "\', ]");
		conn.eval("rawData_plot$obsTime <- as.numeric(rawData_plot$obsTime)");
		conn.eval("plot_img <- qplot(data=rawData_plot, x=obsTime, y=obsValue,"
				+ "color= COUNTRY, geom = 'line')"
				+ "+ labs(x=NULL, y='Persons, thousands', "
				+ "color = NULL, title= 'Unemployed Statistics Graph')");
		conn.eval("setwd('C:/dev64/temp')");
		conn.eval("ggsave('plot.png')");
		//conn.eval("dev.off()");
		//conn.eval("rawImg=readBin('C:/dev64/temp/data.jpg' , 'raw', 1024*1024)");
		//conn.eval("unlink('data.jpg')");
		//retImg = conn.eval("rawImg").asBytes();
		//return retImg;
	}

	/*	
	@Override
	public byte[] returnSimpleImg() throws Exception {
		byte retImg[] = null;
		conn.eval("jpeg('test.jpg')");
		conn.eval("x <- 1:10");
		conn.eval("barplot(x, names='SALES', col=rainbow(15))");
		conn.eval("dev.off()");
		conn.eval("r=readBin('test.jpg', 'raw', 1024*1024)");
		conn.eval("unlink('test.jpg')");
		retImg = conn.eval("r").asBytes();
		return retImg;
	}
	*/
	
	
}
