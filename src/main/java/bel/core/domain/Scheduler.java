package bel.core.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by borino on 31.01.2016.
 */
@Entity
@SequenceGenerator(name = "seq_generator", sequenceName = "seq_scheduler", allocationSize = 1)
public class Scheduler implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
	private Long id;

	@Column(nullable = false, unique = true)
	private String code;

	@Column
	private String description;
	@Column
	private String cron;

	public Scheduler() {
	}

	public Scheduler(String code, String description, String cron) {
		this.code = code;
		this.description = description;
		this.cron = cron;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Scheduler scheduler = (Scheduler) o;

		if (id != null ? !id.equals(scheduler.id) : scheduler.id != null) return false;
		if (code != null ? !code.equals(scheduler.code) : scheduler.code != null) return false;
		if (description != null ? !description.equals(scheduler.description) : scheduler.description != null)
			return false;
		if (cron != null ? !cron.equals(scheduler.cron) : scheduler.cron != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (code != null ? code.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (cron != null ? cron.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Scheduler{" +
				"id=" + id +
				", code='" + code + '\'' +
				", description='" + description + '\'' +
				", cron='" + cron + '\'' +
				'}';
	}
}

