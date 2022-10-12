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
                    radius: ''
                }}
                onSubmit={values => {
                    console.log(values);
                    axios.post('/api/locations', {
                        latitude: values.latitude,
                        longitude: values.longitude,
                        radius: values.radius
                    }).then(res => setWordOnSubmit(res.data))
                      .catch(err => console.log(err));
                }}
            >
                <Form>
                    <Field id="latitude" name="latitude" placeholder="Latitude" />
                    <Field id="longitude" name="longitude" placeholder="Longitude" />
                    <Field id="radius" name="radius" placeholder="Search Radius" />
                    <button type="submit">Submit</button>
                </Form>
            </Formik>
        </div>
    )
}

export default LocationSelector;