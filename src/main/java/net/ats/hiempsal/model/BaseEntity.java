///////////////////////////////////////////////
//
// net.ats.hiempsal.model.BaseEntity.java is
// a simple JPA Entity
//
///////////////////////////////////////////////

package net.ats.hiempsal.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

/**
 * Simple JavaBean domain object with an id property. Used as a base class for objects
 * needing this property.
 *
 * @author L KHERBICHE
 * @since 0.0.1-RELEASE
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hiem_sequence")
	@SequenceGenerator(name = "hiem_sequence", allocationSize = 1)
    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
