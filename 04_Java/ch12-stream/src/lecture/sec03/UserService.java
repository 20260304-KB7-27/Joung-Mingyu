package lecture.sec03;

import java.util.List;
import java.util.Optional;

public class UserService {
    // Repository 주입
    private final UserRepository repository = new UserRepository();

    public List<User> getUsers() {
        // 비즈니스 로직 들어올 자리
        List<User> users = repository.findAll();
        return users;
    }

    public User getUserById(long id) {
        // Optional<User>
        // 없을 때는 예외를 던짐
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 유저입니다. id = " + id));

        return user;
    }

    // ifPresent -> 값이 없으면 실행 X
    public void printIfExist(long id) {
        repository.findById(id).ifPresent(u -> System.out.println("user = " + u));
    }

    public String getEmail(long id) {
        return repository.findById(id)
                // findById -> Optional<User> -> getEmail -> Optional<Optional<String>>
                // 일반적인 getEmail을 하게 되면 Optional이 중복으로 감싸짐
                // flatMap을 이횽해서 Optional 하나로 처리
                .flatMap(user -> Optional.ofNullable(user.getEmail()))
                .orElse("이메일 없음");
    }
}
