package africa.box.dm.controllers;


import africa.box.dm.db.CompteDao;
import africa.box.dm.dto.KpiDossierDto;
import africa.box.dm.dto.KpiTauxByStatusDto;
import africa.box.dm.dto.KpiTempsTraitementDto;
import africa.box.dm.dto.ReportDto;
import africa.box.dm.service.DmFileServices;
import africa.box.dm.service.KpiServices;
import africa.box.dm.service.MyAppException;
import africa.box.dm.service.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/report")
@CrossOrigin(value = "*", origins = "*")
public class ReportController {
	@Autowired
	Utils utils;
	private static Logger log = LoggerFactory.getLogger(ReportController.class);
	@Autowired
	CompteDao compteDao;

	@Autowired
	DmFileServices dmFileServices;


	@Autowired
	KpiServices kpiServices;

	@GetMapping("/DossierParStatus")
	public List<ReportDto> getNombreDossierParStatusParMoisDeLagence(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
																	 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date finishDate) throws MyAppException{
		return  dmFileServices.getNombreDossierParStatusParMoisDeLagence(startDate,finishDate);
	}

	@GetMapping("/DossierParAgence")
	public List<ReportDto> getNombreDossierParAgence(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
													 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date finishDate) throws MyAppException{
		return  dmFileServices.getNombreDossierParAgence(startDate,finishDate);
	}

	@GetMapping("/KpiByAgence")
	public List<KpiDossierDto> getKpiDossierByAgence(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
													 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date finishDate) throws MyAppException{
		return  kpiServices.getKpiDossierByVariable("agence",startDate,finishDate,null,null);
	}

	@GetMapping("/KpiByUser")
	public List<KpiDossierDto> getKpiDossierByUser(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
												   @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date finishDate) throws MyAppException{
		return  kpiServices.getKpiDossierByVariable("created_by",startDate,finishDate,null,null);
	}

//	@GetMapping("/KpiByStatus")
//	public List<KpiDossierDto> getKpiDossierByStatus(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
//																	 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date finishDate) throws MyAppException{
//		return  kpiServices.getKpiDossierByVariable("status",startDate,finishDate);
//	}

	@PostMapping("/KpiByStatus")
	public List<KpiDossierDto> getKpiDossierByStatus(@RequestBody Map<String,Object> param) throws MyAppException{
		Date startDate = null;
		Date finishDate = null;
		List<String> agences =new ArrayList<>();
		List<String> users =new ArrayList<>();
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse((String) param.get("startDate"));
			finishDate = new SimpleDateFormat("yyyy-MM-dd").parse((String) param.get("finishDate"));
			agences = (List<String>) param.get("agences");
			users = (List<String>) param.get("users");
		}catch (Exception e){
			e.printStackTrace();
		}
		return  kpiServices.getKpiDossierByVariable("status",startDate,finishDate,agences,users);
	}

	@PostMapping("/KpiTempsDeTraitement")
	public List<KpiTempsTraitementDto> getKpiTempsTraitement(@RequestBody Map<String,Object> param) throws MyAppException{
		Date startDate = null;
		Date finishDate = null;
		List<String> agences =new ArrayList<>();
		List<String> users =new ArrayList<>();
		System.out.println(param);
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse((String) param.get("startDate"));
			finishDate = new SimpleDateFormat("yyyy-MM-dd").parse((String) param.get("finishDate"));
			agences = (List<String>) param.get("agences");
			users = (List<String>) param.get("users");
		}catch (Exception e){
			e.printStackTrace();
		}
		return  kpiServices.getKpiTempsTraitementDto(startDate,finishDate,agences,users);
	}

//	@GetMapping("/KpiTempsDeTraitement")
//	public List<KpiTempsTraitementDto> getKpiTempsTraitement(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
//																	 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date finishDate) throws MyAppException{
//		return  kpiServices.getKpiTempsTraitementDto(startDate,finishDate);
//	}

	@PostMapping("/KpiTauxByStatus/{status}")
	public KpiTauxByStatusDto getKpiTauxByStatus(@PathVariable("status")String status, @RequestBody Map<String,Object> param) throws MyAppException{
		Date startDate = null;
		Date finishDate = null;
		List<String> agences =new ArrayList<>();
		List<String> users =new ArrayList<>();
		System.out.println(param);
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse((String) param.get("startDate"));
			finishDate = new SimpleDateFormat("yyyy-MM-dd").parse((String) param.get("finishDate"));
			agences = (List<String>) param.get("agences");
			users = (List<String>) param.get("users");
		}catch (Exception e){
			e.printStackTrace();
		}
		return  kpiServices.getKpiTauxByStatusDto(status,startDate,finishDate,agences,users);
	}

//	@GetMapping("/KpiTauxByStatus/{status}")
//	public KpiTauxByStatusDto getKpiTauxByStatus(@PathVariable("status")String status,@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
//																	 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date finishDate) throws MyAppException{
//		return  kpiServices.getKpiTauxByStatusDto(status,startDate,finishDate);
//	}

//	@PostMapping("/KpiTauxByStatus/{status}")
//	public KpiTauxByStatusDto getKpiTauxByStatus(@PathVariable("status")String status,@RequestBody Map<String,Object> param) throws MyAppException{
//		Date startDate = null;
//		Date finishDate = null;
//		List<String> agences =new ArrayList<>();
//
//		try {
//			startDate = (Date) param.get("startDate");
//			finishDate = (Date) param.get("finishDate");
//			agences = (List<String>) param.get("agences");
//		}catch (Exception e){
//			e.printStackTrace();
//		}
//
//		return  kpiServices.getKpiTauxByStatusDto(status,startDate,finishDate,agences);
//	}

}