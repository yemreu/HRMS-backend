package yunusemreuzun.hrms.entities.dtos;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialPlatformDto {

	private int id;
	private String name;
	private String url;
}
