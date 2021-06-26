package mdar.com.util;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class NextPageDTO {
    private int page;
    private int max;
    private String searchOption;
    private String searchValue;
}
