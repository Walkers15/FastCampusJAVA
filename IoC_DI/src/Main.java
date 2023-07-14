public class Main {
    public static void main(String[] args) {
        String url = "https://www.dnd.ac/projects/9th?teams=10&part=backend";

        // 외부에서 의존성(Encoder 가 필요한 IEncoder 를 주입해줌)
        IEncoder encoder = new Encoder(new Base64Encoder());
        String result = encoder.encode(url);
        System.out.println(result);

        encoder = new Encoder(new UrlEncoder());
        String urlResult = encoder.encode(url);
        System.out.println(urlResult);
    }
}