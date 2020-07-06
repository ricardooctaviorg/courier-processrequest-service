package com.a4sys.courier.repository.dicDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.a4sys.courier.domain.dic.DicCampanas;
public interface IDicCampanas extends JpaRepository<DicCampanas, Long> {
	
    @Query(value="SELECT COUNT(IDEXTERNO)IDEXTERNO FROM DICCAMPANAS WHERE IDEXTERNO=:idExterno", nativeQuery = true) 
    int ExistCampaign(@Param("idExterno") String idExterno);

}
