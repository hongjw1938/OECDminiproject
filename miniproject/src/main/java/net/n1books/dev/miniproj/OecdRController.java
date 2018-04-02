package net.n1books.dev.miniproj;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("projTest")
public class OecdRController {
	private static final Logger logger = LoggerFactory.getLogger(OecdRController.class);
	
	@Autowired
	private OecdRService service;
	
	//전체 데이터셋의 목록을 가져옴
	@RequestMapping("freelancer")
	public String getDataset(Model model) {
		logger.info("dataset을 가져옵니다..");
		List<String[]> result;
		//byte[] getImg;
		try {
			result = service.getDatasets();
			model.addAttribute("all_Data_Sets",result);
			
			//getImg = DatatypeConverter.parseBase64Binary(service.getSimpleImg().toString());
			//BufferedImage img = ImageIO.read(new ByteArrayInputStream(getImg));
			
			//model.addAttribute("simpleImg", img);
			//simpleImgTest(service, response);
		} catch (Exception e) {
			logger.info("dataset을 가져오지 못했습니다.");
			e.printStackTrace();
		}
		return "projTest/freelancer";
	}
	
	//특정 데이터 셋의 분류 기준을 가져옴
	@RequestMapping(value= "specific/{data_id}",
			headers="Accept=application/json;charset=UTF-8",
			produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public Map<String, String[]> getSpecificSets(@PathVariable String data_id) {
		logger.info("특정 dataset을 가져옵니다.");
		Map<String, String[]> result = null;
		
		try {
			result = service.getSpecificSet(data_id);
			logger.info("specific dataset을 가져왔습니다");
		} catch (Exception e) {
			logger.info("specific dataset을 가져오지 못했습니다.");
		}
		return result;
	}
	
	//특정 데이터 셋의 분류기준의 세부 내용을 가져옴
	@RequestMapping(value="detail/{data_id}",
			headers="Accept=application/json;charset=UTF-8",
			produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public Map<String, String[]> getDetails(@PathVariable String data_id){
		logger.info("dataset의 상세 세부 분류 기준을 가져옵니다.");
		Map<String, String[]> retResult = null;
		try {
			retResult = service.getDetails(data_id);	
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("상세 세부 분류 정보를 가져오지 못했습니다.");
		}
		return retResult;
	}
	
	
	//특정 주제와 관련된 데이터셋의 목록을 가져옴
	@RequestMapping("freelancer/{subject}")
	public String search_Datasets(@PathVariable String subject, Model model) {
		logger.info(subject + " data를 가져옵니다..");
		List<String[]> result;
		try {
			result = service.search_Datasets(subject);
			model.addAttribute("searched_set",result);
		} catch(Exception e) {
			logger.info("dataset을 찾아내지 못했습니다.");
			e.printStackTrace();
		}
		return "projTest/freelancer";
	}
	
	
	
	//엑셀 형태의 데이터 결과를 가져옴.
	@RequestMapping(value = "toExcel", method=RequestMethod.GET)
	public void toExcel(HttpServletResponse response,
			@RequestParam String query, @RequestParam(defaultValue="1900") String start_time,
					@RequestParam(defaultValue="2018") String end_time) {
		logger.info("excel data를 가져옵니다.");
		
		String[][] result;
		try {
			result = service.getActualData(query, start_time, end_time);
			
			//NPOIFSFileSystem fs = new NPOIFSFileSystem(new File("C:/Users/student/Downloads/data.xls"));
			//워크북 생성
			Workbook wb = new HSSFWorkbook();
			
			
			//sheet 생성
			Sheet sheet1 = wb.createSheet("firstSheet");
			//너비 설정
			sheet1.setColumnWidth(0, 10000);
			//Cell 스타일 생성
			CellStyle cellStyle = wb.createCellStyle();
			//줄바꿈
			cellStyle.setWrapText(true);
			
			//--------------------------------------
			Row row = null;
			Cell cell = null;
			
			//각 줄 써내려가기
			
			for(int i=0; i < result[0].length; i++) {
				for(int j=0; j < result.length; j++) {
					if(j==0) {
						row = sheet1.createRow(i);
					}
					cell = row.createCell(j);
					cell.setCellValue(result[j][i]);
				}
			}

			
			File xlsFile = new File("C:/dev64/temp", "data.xls");
			
			FileOutputStream fileOut = new FileOutputStream(xlsFile);
			wb.write(fileOut);
			fileOut.close();
			
			wb.close();
			
			response.setContentType("application/vnd.ms-excel; charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment; fileName=" + xlsFile.getName());
			response.setHeader("Content-Description", "JSP Generated Date");
			
			InputStream is = null;
			
			OutputStream os = response.getOutputStream();
			is = new FileInputStream(xlsFile);
			FileCopyUtils.copy(is, os);
			
			
			
			is.close();
			os.flush();
			os.close();			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	@RequestMapping(value="getImg", method=RequestMethod.GET)
	public void getImg(@RequestParam String duration, HttpServletResponse response) {
		//byte[] img;
		//BufferedOutputStream output = null;
		//FileInputStream fis = null;
		try {
			logger.info("실업률 img를 가져옵니다.");
			service.getImg(duration);
			
			File file = new File("C:/dev64/temp/plot.png");
			
			
			response.setContentType("application/octet-stream");
			response.setContentLength((int)file.length());
			response.setHeader("Content-Disposition", 
								"attachment; fileName=data.png");
			
			//fis = new FileInputStream("C:/dev64/temp/data.jpg");
			//ByteArrayInputStream input = new ByteArrayInputStream(img);
			//output = new BufferedOutputStream(response.getOutputStream());
			//byte[] buffer = new byte[4096];
			//int length = 0;
			//while((length = input.read(buffer)) >= 0) {
				//output.write(buffer, 0, length);
			//	fos.write(buffer, 0, length);
			//}
			//fos.flush();
			//fos.close();
			
			InputStream is = new BufferedInputStream(new FileInputStream(file));
			
			BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
			int read = 0;
			byte[] buffer = new byte[4096];
			while((read = is.read(buffer)) >= 0) {
				out.write(buffer, 0 , read);
			}
			is.close();
			out.flush();
			out.close();
			
			
			//OutputStream os = response.getOutputStream();
			
			//FileCopyUtils.copy(is, os);
			
			//is.close();
			//os.flush();os.close();
			
			
		} catch (Exception e) {
			logger.info("이미지를 불러올 수 없습니다.");
			e.printStackTrace();
		}/* finally {
			if(output != null) {
				try {
					
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}*/
		
	}
	/*//이미지를 출력하는 method
	@RequestMapping("imgTest")
	public void simpleImgTest(HttpServletResponse response) {
		byte[] img;
		BufferedOutputStream output = null;
		try {
			File file = new File("C:/dev64/temp", "data.jpg");
			logger.info("simpleImg 를 가져옵니다..");
			img = service.getSimpleImg();
			response.setContentType("application/octet-stream");
			response.setContentLength(img.length);
			response.setHeader("Content-Disposition", 
								"attachment;");
				
				
			ByteArrayInputStream input = new ByteArrayInputStream(img);
			FileOutputStream os = new FileOutputStream(file);
			
			output = new BufferedOutputStream(response.getOutputStream());
			
			byte[] buffer = new byte[4096];
			int length = 0;
			while((length = input.read(buffer))>=0) {
				output.write(buffer, 0, length);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(output != null) {
				try {
					output.flush();
					output.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}	*/
}
