package br.com.aweb.to_do_list.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class MaintenanceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do solicitante é obrigatório.")
    @Size(min = 3, max = 100, message = "O nome do solicitante deve ter entre 3 e 100 caracteres.")
    @Column(length = 100, nullable = false)
    private String requesterName;

    @NotBlank(message = "A descrição do problema é obrigatória.")
    @Size(min = 10, max = 500, message = "A descrição do problema deve ter entre 10 e 500 caracteres.")
    @Column(length = 500, nullable = false)
    private String problemDescription;

    @Column(nullable = false)
    private LocalDateTime requestTimestamp = LocalDateTime.now();

    @Column(nullable = true)
    private LocalDateTime finishedTimestamp;
}