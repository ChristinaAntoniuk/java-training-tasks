package training.insurance.model.entity;

import java.sql.SQLException;

import training.insurance.DataBaseConnection;

/**
 * Class describes death probability in the life insurance.
 */

public class Death extends Derivative{
	/**
	 * Price of death insurance for policy holder.
	 */
	private float price;
	/**
	 * Natural causes probability.
	 */
	private float NCprobability;
	/**
	 * Accident causes probability.
	 */
	private float Aprobability;
	/**
	 * Age of policy holder.
	 */
	private int age;
	/**
	 * Class, that connects to SQL data base.
	 */
	DataBaseConnection dataBaseConnection;

	public Death(PolicyHolder policyHolder) throws SQLException{
		dataBaseConnection = new DataBaseConnection();
		dataBaseConnection.setDeathAccidentProbability();
		dataBaseConnection.setDeathNaturalCausesProbability();
		age = policyHolder.getAge();
		for (int age : dataBaseConnection.getDeathNaturalCausesProbability().keySet()){
			if (this.age <= age){
				this.NCprobability = dataBaseConnection.getDeathNaturalCausesProbability().get(age);
				break;
			}
			this.NCprobability = dataBaseConnection.getDeathNaturalCausesProbability().get(age);
		}
		for (int age : dataBaseConnection.getDeathAccidentProbability().keySet()){
			if (this.age <= age){
				this.Aprobability = dataBaseConnection.getDeathAccidentProbability().get(age);
				break;
			}
			this.Aprobability = dataBaseConnection.getDeathAccidentProbability().get(age);
		}
		price = LIFE_RATE - (LIFE_RATE * (NCprobability+Aprobability) * RATE_COEFFICIENT);
	}

	@Override
	public float getPrice() {
		return price;
	}

	public float getNCprobability() {
		return NCprobability;
	}

	public float getAprobability() {
		return Aprobability;
	}
}
