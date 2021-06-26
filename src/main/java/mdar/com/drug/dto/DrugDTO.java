package mdar.com.doctor.dto;

import lombok.*;
import mdar.com.doctor.Entity.DrugEntity;
import mdar.com.util.Util;
import org.modelmapper.ModelMapper;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DrugDTO {

    private int id;
    private LocalDateTime crawlingDate;
    private String itemSeq;
    private String itemName;
    private String entpName;
    private String cnsgnManuf;
    private String etcOtcOcde;
    private String classNo;
    private String chart;
    private String barCode;
    private String materialName;
    private String eeDocID;
    private String udDocID;
    private String nbDocID;
    private String insertFile;
    private String storageMethod;
    private String validTerm;
    private String reexamTarget;
    private String reexamDate;
    private String packUnit;
    private String ediCode;
    private String docText;
    private String permitKindName;
    private String entpNo;
    private String makeMaterialFlag;
    private String newdrugClassName;
    private String indutyType;
    private String cancelDate;
    private String cancelName;
    private String changeDate;
    private String narcoticKindCode;
    private String gbnName;
    private String eeDocData;
    private String udDocData;
    private String nbDocData;
    private String pnDocData;
    private String mainItemIngr;
    private String ingrName;
    private String itemPermitDate;

    public static DrugDTO toDTO(DrugEntity drugEntity) {
        ModelMapper modelMapper = Util.getInstance().getMapper();
        DrugDTO drugDTO = modelMapper.map(drugEntity, DrugDTO.class);
        return drugDTO;
    }
}
