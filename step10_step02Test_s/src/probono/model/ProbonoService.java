package probono.model;

import java.sql.SQLException;
import java.util.ArrayList;

import probono.exception.MessageException;
import probono.exception.NotExistException;
import probono.model.dto.ActivistDTO;
import probono.model.dto.ProbonoDTO;
import probono.model.dto.ProbonoProjectDTO;
import probono.model.dto.RecipientDTO;
import probono.model.entity.ActivistEntity;
import probono.model.entity.ProbonoProjectEntity;
import probono.model.entity.RecipientEntity;

public class ProbonoService {
	
	//Probono - CRUD
	public static void notExistProbono(String probonoId) throws NotExistException, SQLException{
		ProbonoDTO probono = ProbonoDAO.getProbono(probonoId);
		if(probono == null){
			throw new NotExistException("검색하진 재능기부 정보가 없습니다.");
		}
	}
	
	//모든 probono 정보 반환
	public static ArrayList<ProbonoDTO> getAllProbonos() throws SQLException{
		return ProbonoDAO.getAllProbonos();
	}
	//probono id로 검색
	public static ProbonoDTO getProbono(String probonoId) throws SQLException, NotExistException{
		ProbonoDTO probono = ProbonoDAO.getProbono(probonoId);
		if(probono == null){
			throw new NotExistException("검색하신 재능기부 정보가 없습니다.");
		}
		return probono;
	}
	//새로운 probono 저장
	public static boolean addProbono(ProbonoDTO probono) throws SQLException{
		return ProbonoDAO.addProbono(probono);
	}
	//기존 probono 수정
	public static boolean updateProbono(String probonoId, String probonoPurpose) throws SQLException, NotExistException{
		notExistProbono(probonoId);
		return ProbonoDAO.updateProbono(probonoId, probonoPurpose);
	}
	//probono 삭제
	public boolean deleteProbono(String probonoId) throws SQLException, NotExistException{
		notExistProbono(probonoId);
		return ProbonoDAO.deleteProbono(probonoId);
	}
		
	
	
	//Activist - CRUD
	public static void notExistActivist(String activistId) throws Exception{
		ActivistEntity activist = ActivistDAO.getActivist(activistId);
		if(activist == null){
			throw new NotExistException("검색하는 재능 기부자가 미 존재합니다.");
		}
	}
	
	// 기부자 추가
	public static boolean addActivist(ActivistEntity activist) throws MessageException{
		boolean result = false;
		try{
			result = ActivistDAO.addActivist(activist);
		}catch(Exception s){
			throw new MessageException("이미 존재하는 ID입니다 다시 시도 하세요");
		}
		return result;
	}
	
	//재능 기부자 수정 메소드[ActivistDAO의 updateActivist()]
	public static boolean updateActivist(String activistId, String major) throws Exception {		
		notExistActivist(activistId);
		boolean result = ActivistDAO.updateActivist(activistId, major);
		if(!result){
			throw new NotExistException("재능 기부자 정보 갱신 실패");
		}
		return result;
	}
	
	
	//재능 기부자 삭제 메소드[ ActivistDAO.deleteActivist()]
	public static boolean deleteActivist(String activistId) throws Exception {
		notExistActivist(activistId);
		boolean result = ActivistDAO.deleteActivist(activistId);
		if(!result){
			throw new NotExistException("재능 기부자 정보 삭제 실패");
		}
		return result;
	}
	
	public static ActivistEntity getActivist(String activistId) throws Exception{
		ActivistEntity activist = ActivistDAO.getActivist(activistId);
		if(activist == null){
			throw new NotExistException("검색하는 재능 기부자가 미 존재합니다.");
		}
		return ActivistDAO.getActivist(activistId);
	}
	
	public static ArrayList<ActivistDTO> getAllActivists() throws Exception{
		return (ArrayList<ActivistDTO>) ActivistDAO.getAllActivists();
	}
	
	//Recipient - CRUD
	public static void notExistRecipient(String recipientId) throws Exception{
		RecipientEntity recipient = RecipientDAO.getRecipient(recipientId);
		if(recipient == null){
			throw new NotExistException("검색하는 재능 수해자가 미 존재합니다.");
		}
	}
	
	//수혜자 추가
	public static boolean addRecipient(RecipientEntity recipient) throws MessageException{
		boolean result = false;
		try {
			result = RecipientDAO.addRecipient(recipient);
		}catch(Exception s) {
			throw new MessageException("");
		}
		return result;
	}
	
	
	public static boolean updateRecipient(String recipientId, String receiveHopeContent) throws Exception{
		notExistRecipient(recipientId);
		return RecipientDAO.updateRecipient(recipientId, receiveHopeContent);
	}
	
	
	public static boolean deleteRecipient(String recipientId) throws Exception{
		notExistRecipient(recipientId);
		boolean result = RecipientDAO.deleteRecipient(recipientId);
		if(!result){
			throw new NotExistException("재능 수혜자 정보 삭제 실패");
		}
		return result;
	}
	public static RecipientEntity getRecipient(String recipientId) throws Exception{
		return RecipientDAO.getRecipient(recipientId);
	}
	public static ArrayList<RecipientDTO> getAllRecipients() throws SQLException{
		return (ArrayList<RecipientDTO>) RecipientDAO.getAllRecipients();
	}
	
	
	//ProjectProjectDAO - CRUD
	public static void notExistProbonoProject(int probonoProjectId) throws Exception{
		ProbonoProjectEntity probonoProject = ProbonoProjectDAO.getProbonoProject(probonoProjectId);
		if(probonoProject == null){
			throw new NotExistException("검색하는 재능기부 프로젝트가 미 존재합니다.");
		}
	}
	
	//새로운 Probono Project 등록
	public static boolean addProbonoProject(ProbonoProjectEntity probonoProject) throws Exception{
		boolean result = false;
		try {
			result = ProbonoProjectDAO.addProbonoProject(probonoProject);
		} catch(Exception s) {
			throw new MessageException("이미 존재하는 프로젝트 입니다.");
		}
		return result;
	}
	
	//존재하는 Probono Project의 재능 기부자 수정
	public static boolean updateProbonoProjectActivist(int probonoProjectId, String activistId) throws Exception{
		notExistProbonoProject(probonoProjectId);
		boolean result =  ProbonoProjectDAO.updateProbonoProjectActivist(probonoProjectId, activistId);
		if(!result) {
			throw new NotExistException("프로젝트 정보 갱신 실패");
		}
		return result;
	}
		
	//존재하는 Probono Project의 재능 수해자 수정
	public static boolean updateProbonoProjectReceive(int probonoProjectId, String  receiveId) throws Exception{
		notExistProbonoProject(probonoProjectId);
		return ProbonoProjectDAO.updateProbonoProjectReceive(probonoProjectId, receiveId);
	}
	
	//존재하는 Probono Project 삭제
	public static boolean deleteProbonoProject(int probonoProjectId) throws Exception{
		notExistProbonoProject(probonoProjectId);
		return ProbonoProjectDAO.deleteProbonoProject(probonoProjectId);
	}
	
	//특정 Probono Project 검색 
	public static ProbonoProjectEntity getProbonoProject(int probonoProjectId) throws Exception{
		ProbonoProjectEntity probonoProject = ProbonoProjectDAO.getProbonoProject(probonoProjectId);
		if(probonoProject == null){
			throw new NotExistException("검색하는 재능기부 프로젝트가 미 존재합니다.");
		}
		return probonoProject;
	}
	
	//모든 Probono Project 검색 
	public static ArrayList<ProbonoProjectDTO> getAllProbonoProjects() throws Exception{
		return (ArrayList<ProbonoProjectDTO>) ProbonoProjectDAO.getAllProbonoProjects();
	}
}
