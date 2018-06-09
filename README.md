# Dagger2 MVP Simple Example
## Summary 
This app is a simple example of using MVP and Dagger2 to externalize the creation of dependencies from the classes that use them.
Project based on [The Movie Database (TMDb) API](https://developers.themoviedb.org/3/getting-started/introduction)

## Key concepts

**Dagger2** is a fully static, compile-time dependency injection framework for both Java and Android. It is an adaptation of an earlier version created by Square and now maintained by Google.

Here is a list of other **advantages** for using Dagger 2:
* Simplifies access to shared instances. 
* Easy configuration of complex dependencies. 
* Easier unit and integration testing 
* Scoped instances 

Dependency injection frameworks take charge of object creation. For example, in Dagger2 MVP I create the ItemPresenter in MainActivity: 
```
public class MainActivity extends AppCompatActivity implements ItemsContract.View {   
    @Inject
    ItemPresenter itemPresenter;
 ```
 Dagger2 takes care of creation and figuring out the dependencies:
 
```@Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
```
 
ActivityBindingModule - This module has a @ContributesInjector for MainActivity. 
```
@Module
public abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = ItemModule.class)
    abstract MainActivity mainActivity();
}
```

ApplicationComponent - Here is where we register modules which bring inindividual providers to our app. 
```
@Singleton
@Component(modules = {ItemRepositoryModule.class,
        ApplicationModule.class,
        ActivityBindingModule.class,
        AndroidInjectionModule.class})

public interface  ApplicationComponent extends AndroidInjector<Application>  {
```


Lastly application extend DaggerApplication which will inject (provide) dependencies when we need them.
```public class Application extends DaggerApplication  {    
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder().application(this).build();
    }
```
## Open-source libraries used

- Dagger2
- Picasso
- ButterKnife
- Sugar ORM
- Retrofit

## License

    Copyright 2018 Polina Sliusarchuk

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
