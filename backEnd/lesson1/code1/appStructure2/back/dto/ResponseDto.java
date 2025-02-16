package lesson1.code1.appStructure2.back.dto;

public class ResponseDto <T> {

    private int responseCode;
    // 200 -OK
    // 400 - error
    // 404 - not found
    //

    private T responseInfo;

    private String message;
    // запись прошла успешно
    // таких данных в коллекции нет


    public ResponseDto(int responseCode, T responseInfo, String message) {
        this.responseCode = responseCode;
        this.responseInfo = responseInfo;
        this.message = message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public T getResponseInfo() {
        return responseInfo;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "responseCode=" + responseCode +
                ", responseInfo=" + responseInfo +
                ", message='" + message + '\'' +
                '}';
    }
}
