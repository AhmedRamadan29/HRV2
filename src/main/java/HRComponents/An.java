//package HRComponents;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.MappedSuperclass;
//import jakarta.persistence.PersistenceContext;
//
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.PastOrPresent;
//import java.util.Date;
//
// class An {
//    @PastOrPresent(message = "Publish Date must be in the past or present")
//    private Date date;
//    @NotBlank(message = "email is mandatory")
//    @NotNull(message = "Add email for user")
//    private String email;
//    @MappedSuperclass
//    private EntityManager entityManager;
//    @PersistenceContext
//    @Column(name = "email")
//    @SuppressWarnings("unchecked")
//
//    private EntityManager entityManager;
//}
