import {Formik, Field, Form} from 'formik';
import axios from 'axios';
import './LocationSelector.css'

const LocationSelector = ({setWordOnSubmit, setLatitude, setLongitude, setTest}) => {

    return (
        <div className='body'>
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
                    }).then(res => {
                        setWordOnSubmit(res.data);
                        setLatitude(values.latitude);
                        setLongitude(values.longitude);
                        let i = 0; 
                        let objArr = [];
                        while (i < res.data.length) {
                            let newObj = {
                                name: res.data[i],
                                place: res.data[i + 1],
                                dist: res.data[i + 2]
                            }
                            i += 4;
                            objArr.push(newObj);
                        }
                        console.log(objArr);
                        setTest(objArr);
                    })
                      .catch(err => console.log(err));
                }}
            >
                <Form className='fullForm'>
                    <Field id="latitude" name="latitude" placeholder="Latitude (-180, 180)" className="fieldBox" />
                    <Field id="longitude" name="longitude" placeholder="Longitude (-180, 180)" className="fieldBox" />
                    <Field id="radius" name="radius" placeholder="Search Radius" className="fieldBox" />
                    <button type="submit" className='submitButton'>Submit</button>
                </Form>
            </Formik>
        </div>
    )
}

export default LocationSelector;