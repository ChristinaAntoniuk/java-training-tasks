package training.insurance.model.entity;

import java.sql.SQLException;

import training.insurance.DataBaseConnection;

/**
 * Class describes disability probability in the life insurance.
 */
public class Disability extends Derivative{
	/**
	 * Price of disability insurance.
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

	public Disability(PolicyHolder policyHolder) throws SQLException{
		dataBaseConnection = new DataBaseConnection();
		dataBaseConnection.setDisabilityAccidentProbability();
		dataBaseConnection.setDisabilityNaturalCausesProbability();
		age = policyHolder.getAge();
		for (int age : dataBaseConnection.getDisabilityNaturalCausesProbability().keySet()){
			if (this.age <= age){
				this.NCprobability = dataBaseConnection.getDisabilityNaturalCausesProbability().get(age);
				break;
			}
			this.NCprobability = dataBaseConnection.getDisabilityNaturalCausesProbability().get(age);
		}
		for (int age : dataBaseConnection.getDisabilityAccidentProbability().keySet()){
			if (this.age <= age){
				this.Aprobability = dataBaseConnection.getDisabilityAccidentProbability().get(age);
				break;
			}
			this.Aprobability = dataBaseConnection.getDisabilityAccidentProbability().get(age);
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
