package ru.javawebinar.topjava.repository.inmemory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class InMemoryUserRepository implements UserRepository {

    private final Map<Integer, User> repositoryUser = new ConcurrentHashMap<>();
    private final AtomicInteger counterUser = new AtomicInteger(0);
    private static final Logger log = LoggerFactory.getLogger(InMemoryUserRepository.class);

    public final static int USER_ID=1;
    public final static int ADMIN_ID=2;





    @Override
    public User save(User user) {
        log.info("save {}", user);
        if (user.isNew()) {
            user.setId(counterUser.incrementAndGet());
            repositoryUser.put(user.getId(), user);
            return user;
        }


//         handle case: update, but not present in storage

        return repositoryUser.computeIfPresent(user.getId(), (id, oldUser) -> user);
    }

    @Override
    public boolean delete(int id) {
        log.info("delete {}", id);

        return repositoryUser.remove(id)!=null;
    }
    @Override
    public User get(int id) {
        log.info("get {}", id);
        return repositoryUser.get(id);
    }

    @Override
    public List<User> getAll() {
        log.info("getAll");
//        repositoryUser.values().stream().sorted((o1, o2) -> o1.getName().length()-o2.getName().length());

        return repositoryUser.values().stream().sorted(Comparator.comparing(User::getName).thenComparing(User::getEmail))
                .collect(Collectors.toList());
    }

    @Override
    public User getByEmail(String email) {
        log.info("getByEmail {}", email);

        for (Map.Entry<Integer, User> o :repositoryUser.entrySet()) {
          String emailUser=o.getValue().getEmail();
          if(emailUser.equals(email)){
              return o.getValue();
          }

        }

        return null;
    }
}





