public class Encoder implements IEncoder{

    private final IEncoder iEncoder;

    // 의존 주입, DI
    public Encoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }
    public String encode(String message) {

        return iEncoder.encode(message);
    }
}
