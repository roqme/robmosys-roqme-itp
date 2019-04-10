#ifndef CONTEXTREADERLISTENER_H
#define CONTEXTREADERLISTENER_H


namespace Roqme
{

/**
 * Clase utilizada para recepción de datos asíncronos
 **/	
template <typename T>
class RoqmeDDSListener 
{
public:
	
	virtual ~RoqmeDDSListener(){}

	/**
	 * Método que se ejecuta cuando hay un dato disponible
	 * @param data. Dato recibido
	 */
    virtual void dataAvailable(const T& data, const dds::sub::SampleInfo& sampleInfo) = 0;
	
	virtual void dataAvailable(dds::sub::DataReader<T>& dr)
	{
		dds::sub::LoanedSamples<T> samples = dr.take();
		if(samples.length() > 0 && (*samples.begin()).info().valid())
		{
			for (auto sample = samples.begin(); sample < samples.end(); ++sample)
			{
				dataAvailable(sample->data(), sample->info());
			}
		}
	}

};

} // namespace

#endif // CONTEXTREADERLISTENER_H
