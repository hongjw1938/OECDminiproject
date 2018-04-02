package net.n1books.dev.miniproj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OecdRServiceImpl implements OecdRService{
	
	@Autowired
	@Qualifier("rConnection")
	private OecdRDAO dao;
	
	private String[][] result;
	
	private List<String[]> makeList(String[][] arrays){
		List<String[]> lists = new ArrayList<String[]>();
		List<String> listTemp = new ArrayList<String>();
		for(int i=0; i < arrays[0].length; i++) {
			listTemp.add(arrays[0][i] + "$" + arrays[1][i]);
		}
		
		for(String combined : listTemp) {
			StringTokenizer st = new StringTokenizer(combined, "$");
			String[] temp = new String[2];
			temp[0] = st.nextToken();
			temp[1] = st.nextToken();
			System.out.println(temp[0] + " : " + temp[1]);
			lists.add(temp);
		}
		return lists;
	}
	
	@Override
	public List<String[]> getDatasets() throws Exception{
		result = dao.getDatasets();
		
		return makeList(result);
	}

	@Override
	@Test
	public Map<String, String[]> getSpecificSet(String id) throws Exception {
		result = dao.getSpecificSet(id);
		
		System.out.println("serviceImpl입니다.");
		Map<String, String[]> map = new HashMap<String, String[]>();
		for(int i=0; i < result.length; i++) {
			String[] temp = new String[result[i].length-1];
			for(int j=0; j < result[i].length-1; j++) {
				//System.out.println(test.df_result[i][j]);
				temp[j] = result[i][j+1];
			}
			map.put(result[i][0], temp);
		}
		for(String ids : map.keySet()) {
			System.out.println(ids);
			for(String label : map.get(ids)) {
				System.out.println(label);
			}
		}
		
		return map;
	}

	@Override
	public Map<String, String[]> getDetails(String id) throws Exception {
		result = dao.getDetails(id);
		System.out.println("DAO에서 Service로 이동했습니다.");
		
		Map<String, String[]> map = new HashMap<String, String[]>();
		for(int i=0; i < result.length; i++) {
			String[] temp = new String[result[i].length-1];
			for(int j=0; j < result[i].length-1; j++) {
				//System.out.println(test.df_result[i][j]);
				temp[j] = result[i][j+1];
			}
			map.put(result[i][0], temp);
		}
		for(String ids : map.keySet()) {
			System.out.println(ids);
			for(String label : map.get(ids)) {
				System.out.println(label);
			}
		}
		
		return map;
	}
	
	@Override
	public List<String[]> search_Datasets(String subject) throws Exception {
		result = dao.search_Datasets(subject);
		
		return makeList(result);
	}

	@Override
	public void getImg(String duration) throws Exception {
		dao.getImg(duration);
	}

	/*@Override
	public byte[] getSimpleImg() throws Exception {
		return dao.returnSimpleImg(); 
	}*/


	@Override
	public String[][] getActualData(String query, String start_time, String end_time) throws Exception {
		String[][] retResult = dao.getActualData(query, start_time, end_time);
		for(int i=0; i < retResult.length; i++) {
			System.out.println("첫번 째꺼! : " + retResult[i][0]);
			for(int j=0; j < retResult[i].length; j++) {
				System.out.println(retResult[i][j]);
			}
		}
		
		
		return retResult;
	}

	

	


	
}
