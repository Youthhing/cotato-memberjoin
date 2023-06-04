package youth.memberjoin.web.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AfterLoginDto {
    private String id;
    private String name;

    public AfterLoginDto(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
