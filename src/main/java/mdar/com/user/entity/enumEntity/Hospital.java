package mdar.com.user.entity.enumEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum Hospital {
    ChungBuk("충북대학교", 1);

    private String value;
    private int order;
    private Hospital(String value, int i){
        this.value = value;
        this.order = i;
    }



}
