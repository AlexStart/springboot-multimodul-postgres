package my.springboot.multimodul.postgres.domain;
//import javax.validation.constraints.NotNull;
import my.springboot.multimodul.postgres.domain.Recommendation;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by gladivs on 16.05.2017.
 */
@Entity
@Table(name="users")
public class User implements Serializable {
    @Id
    @GeneratedValue(generator = "users_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "users_seq", sequenceName = "public.users_seq", allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
   // @NotNull
    private String firstName;
    @Column(name = "last_name")
  //  @NotNull
    private String lastName;
   // @NotNull
    private Integer age;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Recommendation> recommendations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Recommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }

}
