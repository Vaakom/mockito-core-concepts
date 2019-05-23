package vaakom.mockito.adv.reposiory;

import org.springframework.data.jpa.repository.JpaRepository;
import vaakom.mockito.adv.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
