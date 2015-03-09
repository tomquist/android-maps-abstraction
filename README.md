# android-maps-abstraction
This library mirrors the complete Google Maps API v2 for Android using only interfaces. This enables you to write maps code once and use it with all compatible maps APIs. Currently there are bindings for Google Maps v2 and Amazon Maps v2.

## Getting Started

There are two approaches for integrating maps libraries:

1. **Fat apk**: Single apk containing both maps libraries
2. **Thin apk**: Multiple apks, containing only a single maps library _(recommended)_

### Fat apk approach
Add the following to your Gradle build file

	dependencies {
	    compile 'de.quist.app.maps:google-maps-abstraction:1.0+'
	    compile 'de.quist.app.maps:amazon-maps-abstraction:1.0+'
	}

Now you have to decide on runtime which library to use. This is typically done in an early stage, e.g. in your Application subclass. Depending on which library is available, either use ``de.quist.app.maps.google.GoogleMapBinding.INSTANCE`` (for Google Maps Library) or ``de.quist.app.maps.amazon.AmazonMapBinding.INSTANCE`` (for Amazon Maps Library) for creating maps objects.

### Thin apk approach
This is the preferred approach and is implemented in the demo project. Create two flavors of your app and specify a Maps binding in your BuildConfig class:

	android {
		
		...

		productFlavors {
	        play {
	            buildConfigField "de.quist.app.maps.MapBinding", "MAP_BINDING", "de.quist.app.maps.google.GoogleMapBinding.INSTANCE"
	        }
	        amazon {
	            minSdkVersion 15
	            buildConfigField "de.quist.app.maps.MapBinding", "MAP_BINDING", "de.quist.app.maps.amazon.AmazonMapBinding.INSTANCE"
	        }
	    }
	}
	
	dependencies {
	    playCompile 'de.quist.app.maps:google-maps-abstraction:1.0+'
	    amazonCompile 'de.quist.app.maps:amazon-maps-abstraction:1.0+'
	}


## Migrating an App from Google Maps v2 to abstraction API

1. Rename Google–specific namespaces and classes to the abstraction API versions as described below.
2. Change all instantiation of all ``*Options`` classes by calling the corresponding method on a MapBinding instance. E.g. creation of marker options (``new MarkerOption()``) should be replace with ``binding.markerOptions()``, assuming that variable ``binding`` contains either an instance of ``de.quist.app.maps.amazon.AmazonMapBinding`` or ``de.quist.app.maps.google.GoogleMapBinding``
3. Change calls to ``*Factory`` classes to the corresponding factory instance. E.g. a call to ``CameraUpdateFactory.zoomIn()`` should be replaced by ``binding.cameraUpdateFactory().zoomIn()``
4. For all layout files containing a fragment node with a class attribute ``MapFragment`` or ``SupportMapFragment`` should provide an alternative layout, containing the corresponding Amazon map fragment. If you use the _Light Apk Approach_, provide a separate layout in the resources directory of the corresponding flavor (see demo app).
5. To create instances of ``MapFragment``, ``SupportMapFragment`` or ``MapVIew`` programmatically, use the ``newMapFragmentInstance()``, ``newSupportMapFragmentInstance()`` and ``newMapView()`` methods in ``MapBinding``.
6. To access ``MapFragment`` or ``MapView`` methods, wrap the fragment or view into a ``MapFragmentWrapper`` or ``MapViewWrapper`` by calling ``mapFragmentWrapperFrom()`` or ``mapViewWrapperFrom()``.

| Google Name                     | Abstraction Name                      | Example                                                                            |
|:------------------------------- |:------------------------------------- |:---------------------------------------------------------------------------------- |
| ``com.google.android.gms.maps`` | ``de.quist.app.maps``                 | ``com.google.android.gms.maps.Projection`` &rarr; ``de.quist.app.maps.Projection`` |
| ``GoogleMap``                   | ``Map``                               |                                                                                    |
| ``new *Options()``              | ``binding.*Options()``                | ``new MarkerOptions()`` &rarr; ``binding.markerOptions()``                         |
| ``new LatLng()``                | ``binding.latLng()``                  | ``new LatLng(53.55, 10.0)`` &rarr; ``binding.latLng(53.55, 10.)``                  |
| ``*Factory.*()``                | ``binding.*Factory().*``              | ``CameraUpdateFactory.zoomIn()`` &rarr; ``binding.cameraUpdateFactory().zoomIn()`` |
| ``MapsFragment.newInstance()``  | ``binding.newMapFragmentInstance()``  | ``MapsFragment.newInstance()`` &rarr; ``binding.newMapsFragmentInstance()``        |
| ``Tile.NO_TILE``                | ``binding.noTile()``                  |                                                                                    |
| ``*.builder()``                 | ``binding.*Builder()``                | ``CameraPosition.builder()`` &rarr; ``binding.cameraPositionBuilder()``            |
