package net.n1books.dev.miniproj;

import java.util.List;
import java.util.Map;

public interface OecdRService {
	public List<String[]> getDatasets() throws Exception;
	public List<String[]> search_Datasets(String subject) throws Exception;
	//public byte[] getSimpleImg() throws Exception;
	public String[][] getActualData(String query, String start_time, String end_time) throws Exception;
	public Map<String, String[]> getSpecificSet(String id) throws Exception;
	public Map<String, String[]> getDetails(String id) throws Exception;
	public void getImg(String duration) throws Exception;
}
