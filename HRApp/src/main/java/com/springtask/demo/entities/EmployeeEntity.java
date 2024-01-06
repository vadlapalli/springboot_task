package com.springtask.demo.entities;



import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeEntity {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    private String email;

	    @Column(name = "phone_number")
	    private String phoneNumber;

	    private String address;

	    @Column(name = "created_at")
	    @CreationTimestamp
	    private LocalDateTime createdAt;

	    @Column(name = "updated_at")
	    @UpdateTimestamp
	    private LocalDateTime updatedAt;
	    
	    @ManyToOne()
	    @JoinColumn(name = "department_id", nullable = false)
	    private DepartmentEntity department;

	    @ManyToOne
	    @JoinColumn(name = "position_id", nullable = false)
	    private PositionEntity position;
	    


}
