package se.p950tes.publictransport.app.repository;

import se.p950tes.publictransport.app.repository.datasource.DataSource;
import se.p950tes.publictransport.app.repository.datasource.FileDataSource;
import se.p950tes.publictransport.app.repository.parsing.DeparturesParser;
import se.p950tes.publictransport.app.repository.parsing.ultypes.ULDeparturesResponse;

public class DeparturesRetriever {

	public ULDeparturesResponse fetch(int busStopId) throws Exception {
		
		DataSource dataSource = new FileDataSource("/ul-departures-from-stop-response.txt");
//		DataSource dataSource = new HttpDataSource(ULUrls.getDeparturesUrl(busStopId));
		
		String retrievedData = dataSource.fetchData();
		
		ULDeparturesResponse data = new DeparturesParser().parse(retrievedData);
		
		return data;
	}
}