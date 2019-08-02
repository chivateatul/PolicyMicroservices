package pcr.reports.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pcr.reports.services.ReportsServicesImpl;

@RestController
@RequestMapping("/api/services/reports")
public class ReportsController {

	@Autowired
	ReportsServicesImpl servicesImpl;

	
}
