	package com.springtask.demo.entities;
	
	import java.time.LocalDateTime;
	import java.util.List;
	
	import org.hibernate.annotations.CreationTimestamp;
	import org.hibernate.annotations.UpdateTimestamp;
	
	import jakarta.persistence.CascadeType;
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.OneToMany;
	import jakarta.persistence.Table;
	import lombok.AllArgsConstructor;
	import lombok.Getter;
	import lombok.NoArgsConstructor;
	import lombok.Setter;
	import lombok.ToString;
	
	
	@Entity
	@Table(name = "departments")
	@NoArgsConstructor
	@AllArgsConstructor
	@Getter
	@Setter
	@ToString
	public class Department {
		
		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long id;
	
		    private String name;
	
		    @Column(name = "created_at")
		    @CreationTimestamp
		    private LocalDateTime createdAt;
	
		    @Column(name = "updated_at")
		    @UpdateTimestamp
		    private LocalDateTime updatedAt;
		    
		    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL,orphanRemoval = true)
		    private List<Position> positions;
		    
		    
	
	}
