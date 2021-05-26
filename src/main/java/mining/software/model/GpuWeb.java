package mining.software.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GpuWeb {
    //todo convert into double
    //todo regular expressions doesn`t work, why?

    private String name;
    private String infoAll;
    private String power;
    private String revenue;
    private String profit;
}
