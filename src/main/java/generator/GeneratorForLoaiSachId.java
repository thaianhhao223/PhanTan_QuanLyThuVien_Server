package generator;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class GeneratorForLoaiSachId implements IdentifierGenerator{
	private String prefix = "LoaiSach";
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);// Calender trả về giá trị tháng từ 0 - 11
		String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
		
		// Tạo thêm một chuỗi 6 số ngẫu nhiên phía sau
		Random random = new Random();
		String randomNumber = String.valueOf(random.nextInt(1000000));
		if(randomNumber.length() < 6) {
			for (int i = 0; i < 6 - randomNumber.length(); i++) {
				randomNumber = "0" + randomNumber;
			}
		}
		prefix += year + month + day + randomNumber;
	    return prefix;
	}

}
