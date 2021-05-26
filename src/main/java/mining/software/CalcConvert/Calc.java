package mining.software.CalcConvert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mining.software.model.Gpu;
import mining.software.model.StartData;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calc {
    private StartData data;
    private Gpu device;

    private Double convert(Double value) {
        int precision;
        if(value < 1) {
            precision = 2;
        } else {
            precision = 3;
        }
        MathContext context = new MathContext(precision, RoundingMode.HALF_UP);
        BigDecimal result = new BigDecimal(value, context);
        return result.doubleValue();
    }

    public Double electCost() {
        return convert(this.data.getPricePerKw() / 1000 * 24 * this.device.getPowerConsumption());
    }

    public Double clearProfit() {
        return convert(this.data.getDailyProfit() * this.device.getHashrate());
    }

    public Double profit() {
        double withoutFee = this.data.getDailyProfit() * this.device.getHashrate() - this.electCost();
        double fee = withoutFee * this.data.getAllFees() / 100;
        return convert(withoutFee - fee);
    }

    public long payback() {
        //окупаемость
        return Math.round(device.getPrice() / profit());
    }
}
