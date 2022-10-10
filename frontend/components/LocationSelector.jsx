import {Formik, Field, Form} from 'formik';
import axios from 'axios';

const LocationSelector = ({setWordOnSubmit}) => {

    return (
        <div>
            <p>Location Selector</p>
            <Formik 
                initialValues={{
                    latitude: '',
                    longitude: '',
                }}
                onSubmit={values => {
                    console.log(values);
                    axios.post('/api/locations', {
                        latitude: values.latitude,
                        longitude: values.longitude
                    }).then(res => {
                        setWordOnSubmit(res.data);
                        console.log(`response: ${res}`);
                    });
                }}
            >
                <Form>
                    <Field id="latitude" name="latitude" placeholder="Latitude" />
                    <Field id="longitude" name="longitude" placeholder="Longitude" />
                    <button type="submit">Submit</button>
                </Form>
            </Formik>
        </div>
    )
}

export default LocationSelector;