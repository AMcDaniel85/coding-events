package org.launchcode;


import org.launchcode.models.ContactInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInfoRepository extends CrudRepository<ContactInfo, Integer> {
}
