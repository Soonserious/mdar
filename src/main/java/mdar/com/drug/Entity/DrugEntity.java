package mdar.com.doctor.Entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="item_seq_code")
@Entity
public class DrugEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "crawling_date")
    private LocalDateTime crawlingDate;

    @Column(name = "item_seq")
    private String itemSeq;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "entp_name")
    private String entpName;

    @Column(name = "cnsgn_manuf")
    private String cnsgnManuf;

    @Column(name="etc_otc_ocde")
    private String etcOtcOcde;

    @Column(name = "class_no")
    private String classNo;

    @Column(name = "chart")
    private String chart;

    @Column(name = "bar_code")
    private String barCode;

    @Column(name = "material_name")
    private String materialName;

    @Column(name = "ee_doc_id")
    private String eeDocID;

    @Column(name = "ud_doc_id")
    private String udDocID;

    @Column(name = "nb_doc_id")
    private String nbDocID;

    @Column(name = "insert_file")
    private String insertFile;

    @Column(name = "storage_method")
    private String storageMethod;

    @Column(name = "valid_term")
    private String validTerm;

    @Column(name = "reexam_target")
    private String reexamTarget;

    @Column(name = "reexam_date")
    private String reexamDate;

    @Column(name = "pack_unit")
    private String packUnit;

    @Column(name = "edi_code")
    private String ediCode;

    @Column(name = "doc_text")
    private String docText;

    @Column(name = "permit_kind_name")
    private String permitKindName;

    @Column(name = "entp_no")
    private String entpNo;

    @Column(name = "make_material_flag")
    private String makeMaterialFlag;

    @Column(name = "newdrug_class_name")
    private String newdrugClassName;

    @Column(name = "induty_type")
    private String indutyType;

    @Column(name = "cancel_date")
    private String cancelDate;

    @Column(name = "cancel_name")
    private String cancelName;

    @Column(name = "change_date")
    private String changeDate;

    @Column(name = "narcotic_kind_code")
    private String narcoticKindCode;

    @Column(name = "gbn_name")
    private String gbnName;

    @Column(name="ee_doc_data")
    private String eeDocData;

    @Column(name = "ud_doc_data")
    private String udDocData;

    @Column(name = "nb_doc_data")
    private String nbDocData;

    @Column(name = "pn_doc_data")
    private String pnDocData;

    @Column(name = "main_item_ingr")
    private String mainItemIngr;

    @Column(name = "ingr_name")
    private String ingrName;

    @Column(name = "item_permit_date")
    private String itemPermitDate;
}
