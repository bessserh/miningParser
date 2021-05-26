package mining.software.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GpuWeb {

    //todo hash and measurement in inner class
    private String name;
    private Double hashrate;
    private String measurement;
    private String bestAlgorithm;
    private int power;
    private Double revenue;
    private Double profit;
}
