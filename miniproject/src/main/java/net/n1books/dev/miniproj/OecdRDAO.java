package net.n1books.dev.miniproj;

public interface OecdRDAO {
	public abstract String[][] getDatasets() throws Exception;
	public abstract String[][] search_Datasets(String subject) throws Exception;
	//public abstract byte[] returnSimpleImg() throws Exception;
	public abstract String[][] getActualData(String query, String start_time, String end_time) throws Exception;
	public abstract String[][] getSpecificSet(String id) throws Exception;
	public abstract String[][] getDetails(String id) throws Exception;
	public abstract void getImg(String duration) throws Exception;
}
