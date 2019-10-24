package cl.stephanoapiolaza.redisboilerplate.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Repository
public class MockRepository {

    private static final Logger log = LogManager.getLogger(MockRepository.class);
    private List<String> listView;

    public MockRepository() {
        this.listView = new ArrayList<>();
    }

    @EventListener(ContextRefreshedEvent.class)
    public void insertAll() {
        IntStream.range(0, 10).forEach( e ->
            listView.add(UUID.randomUUID().toString())
        );
    }

    @Cacheable("listView")
    public List<String> findAll() {
        log.debug("findAll method executed once");
        return this.listView;
    }

}
