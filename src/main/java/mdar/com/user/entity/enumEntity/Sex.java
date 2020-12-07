package mdar.com.user.entity.enumEntity;

import lombok.Getter;

@Getter
public enum Sex {
    Man(1),
    Girl(2);
    private int order;
    private Sex(int i){
        this.order = i;
    }
}
