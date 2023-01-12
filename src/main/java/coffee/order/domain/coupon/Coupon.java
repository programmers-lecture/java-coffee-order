package coffee.order.domain.coupon;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Coupon {
    private final HashMap<String,Integer> coupon;

    public Coupon(){
        coupon = new HashMap<>();
        coupon.put("010-1234-1234",10);
        coupon.put("010-0000-0001",8);
        coupon.put("010-5151-5252",4);
        coupon.put("010-4242-6464",20);
    }

    // 휴대폰 번호의 정규식 검사로 유저 정보를 반환
    public Integer findByPhoneNumber(String phoneNumber){
        String customer = regexPhoneNUmber(phoneNumber);
        return coupon.entrySet().stream()
                .filter(m -> m.getKey().equals(customer))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElseThrow(() -> new IllegalArgumentException("회원 정보가 없습니다."));
    }

    // 휴대폰 번호 정규식 검사
    public String regexPhoneNUmber(String phoneNumber){
        String regex = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$";
        if(!Pattern.matches(regex, phoneNumber)){
            throw new IllegalArgumentException("전화번호 형식을 맞춰주십쇼");
        }
        return phoneNumber;
    }

    // 쿠폰 조회
    public int getCoupon(String phoneNUmber){
        return coupon.get(findByPhoneNumber(phoneNUmber));
    }

    // 쿠폰 사용
    public void subtractCoupon(String phoneNumber){
        int couponNumber = getCoupon(phoneNumber);
        int remain = couponNumber - 10;
        coupon.replace(phoneNumber, remain);
    }

    // 쿠폰 적립
    public void addCoupon(String phoneNumber, int count){
        int add = getCoupon(phoneNumber) + count;
        coupon.replace(phoneNumber, add);
    }




}
