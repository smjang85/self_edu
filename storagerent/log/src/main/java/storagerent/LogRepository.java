package storagerent;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="logs", path="logs")
public interface LogRepository extends PagingAndSortingRepository<Logs, Long>{

	Optional<Logs> findByKeyId(String keyId);
}
