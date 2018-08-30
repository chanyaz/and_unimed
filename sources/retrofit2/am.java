package retrofit2;

import com.mopub.volley.toolbox.HttpClientStack.HttpPatch;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.Map;
import java.util.Set;
import okhttp3.ag;
import okhttp3.ai;
import okhttp3.q;
import okhttp3.r;
import okhttp3.s;
import okhttp3.v;
import okhttp3.y;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Url;

final class am<T, R> {
    final aj a;
    final Method b;
    final Annotation[] c;
    final Annotation[][] d;
    final Type[] e;
    Type f;
    boolean g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    String m;
    boolean n;
    boolean o;
    boolean p;
    String q;
    q r;
    v s;
    Set<String> t;
    o<?>[] u;
    Converter<ai, T> v;
    CallAdapter<T, R> w;

    am(aj ajVar, Method method) {
        this.a = ajVar;
        this.b = method;
        this.c = method.getAnnotations();
        this.e = method.getGenericParameterTypes();
        this.d = method.getParameterAnnotations();
    }

    private RuntimeException a(int i, String str, Object... objArr) {
        return a(str + " (parameter #" + (i + 1) + ")", objArr);
    }

    private RuntimeException a(String str, Object... objArr) {
        return a(null, str, objArr);
    }

    private RuntimeException a(Throwable th, int i, String str, Object... objArr) {
        return a(th, str + " (parameter #" + (i + 1) + ")", objArr);
    }

    private RuntimeException a(Throwable th, String str, Object... objArr) {
        return new IllegalArgumentException(String.format(str, objArr) + "\n    for method " + this.b.getDeclaringClass().getSimpleName() + "." + this.b.getName(), th);
    }

    private q a(String[] strArr) {
        r rVar = new r();
        for (String str : strArr) {
            String str2;
            int indexOf = str2.indexOf(58);
            if (indexOf == -1 || indexOf == 0 || indexOf == str2.length() - 1) {
                throw a("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str2);
            }
            String substring = str2.substring(0, indexOf);
            str2 = str2.substring(indexOf + 1).trim();
            if ("Content-Type".equalsIgnoreCase(substring)) {
                v a = v.a(str2);
                if (a == null) {
                    throw a("Malformed content type: %s", str2);
                }
                this.s = a;
            } else {
                rVar.a(substring, str2);
            }
        }
        return rVar.a();
    }

    private o<?> a(int i, Type type, Annotation[] annotationArr) {
        o<?> oVar = null;
        for (Annotation a : annotationArr) {
            o<?> a2 = a(i, type, annotationArr, a);
            if (a2 != null) {
                if (oVar != null) {
                    throw a(i, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                }
                oVar = a2;
            }
        }
        if (oVar != null) {
            return oVar;
        }
        throw a(i, "No Retrofit annotation found.", new Object[0]);
    }

    private o<?> a(int i, Type type, Annotation[] annotationArr, Annotation annotation) {
        String value;
        boolean encoded;
        Class a;
        Type b;
        ParameterizedType parameterizedType;
        Class a2;
        Converter c;
        if (annotation instanceof Url) {
            if (this.l) {
                throw a(i, "Multiple @Url method annotations found.", new Object[0]);
            } else if (this.j) {
                throw a(i, "@Path parameters may not be used with @Url.", new Object[0]);
            } else if (this.k) {
                throw a(i, "A @Url parameter must not come after a @Query", new Object[0]);
            } else if (this.q != null) {
                throw a(i, "@Url cannot be used with @%s URL", this.m);
            } else {
                this.l = true;
                if (type == s.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                    return new ab();
                }
                throw a(i, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
            }
        } else if (annotation instanceof Path) {
            if (this.k) {
                throw a(i, "A @Path parameter must not come after a @Query.", new Object[0]);
            } else if (this.l) {
                throw a(i, "@Path parameters may not be used with @Url.", new Object[0]);
            } else if (this.q == null) {
                throw a(i, "@Path can only be used with relative url on @%s", this.m);
            } else {
                this.j = true;
                Path path = (Path) annotation;
                value = path.value();
                a(i, value);
                return new w(value, this.a.c(type, annotationArr), path.encoded());
            }
        } else if (annotation instanceof Query) {
            Query query = (Query) annotation;
            value = query.value();
            encoded = query.encoded();
            a = an.a(type);
            this.k = true;
            if (Iterable.class.isAssignableFrom(a)) {
                if (type instanceof ParameterizedType) {
                    return new x(value, this.a.c(an.a(0, (ParameterizedType) type), annotationArr), encoded).a();
                }
                throw a(i, a.getSimpleName() + " must include generic type (e.g., " + a.getSimpleName() + "<String>)", new Object[0]);
            } else if (!a.isArray()) {
                return new x(value, this.a.c(type, annotationArr), encoded);
            } else {
                return new x(value, this.a.c(al.a(a.getComponentType()), annotationArr), encoded).b();
            }
        } else if (annotation instanceof QueryName) {
            boolean encoded2 = ((QueryName) annotation).encoded();
            a = an.a(type);
            this.k = true;
            if (Iterable.class.isAssignableFrom(a)) {
                if (type instanceof ParameterizedType) {
                    return new z(this.a.c(an.a(0, (ParameterizedType) type), annotationArr), encoded2).a();
                }
                throw a(i, a.getSimpleName() + " must include generic type (e.g., " + a.getSimpleName() + "<String>)", new Object[0]);
            } else if (!a.isArray()) {
                return new z(this.a.c(type, annotationArr), encoded2);
            } else {
                return new z(this.a.c(al.a(a.getComponentType()), annotationArr), encoded2).b();
            }
        } else if (annotation instanceof QueryMap) {
            a = an.a(type);
            if (Map.class.isAssignableFrom(a)) {
                b = an.b(type, a, Map.class);
                if (b instanceof ParameterizedType) {
                    parameterizedType = (ParameterizedType) b;
                    a2 = an.a(0, parameterizedType);
                    if (String.class != a2) {
                        throw a(i, "@QueryMap keys must be of type String: " + a2, new Object[0]);
                    }
                    return new y(this.a.c(an.a(1, parameterizedType), annotationArr), ((QueryMap) annotation).encoded());
                }
                throw a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
            }
            throw a(i, "@QueryMap parameter type must be Map.", new Object[0]);
        } else if (annotation instanceof Header) {
            value = ((Header) annotation).value();
            a = an.a(type);
            if (Iterable.class.isAssignableFrom(a)) {
                if (type instanceof ParameterizedType) {
                    return new s(value, this.a.c(an.a(0, (ParameterizedType) type), annotationArr)).a();
                }
                throw a(i, a.getSimpleName() + " must include generic type (e.g., " + a.getSimpleName() + "<String>)", new Object[0]);
            } else if (!a.isArray()) {
                return new s(value, this.a.c(type, annotationArr));
            } else {
                return new s(value, this.a.c(al.a(a.getComponentType()), annotationArr)).b();
            }
        } else if (annotation instanceof HeaderMap) {
            a = an.a(type);
            if (Map.class.isAssignableFrom(a)) {
                b = an.b(type, a, Map.class);
                if (b instanceof ParameterizedType) {
                    parameterizedType = (ParameterizedType) b;
                    a2 = an.a(0, parameterizedType);
                    if (String.class != a2) {
                        throw a(i, "@HeaderMap keys must be of type String: " + a2, new Object[0]);
                    }
                    return new t(this.a.c(an.a(1, parameterizedType), annotationArr));
                }
                throw a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
            }
            throw a(i, "@HeaderMap parameter type must be Map.", new Object[0]);
        } else if (annotation instanceof Field) {
            if (this.o) {
                Field field = (Field) annotation;
                value = field.value();
                encoded = field.encoded();
                this.g = true;
                a = an.a(type);
                if (Iterable.class.isAssignableFrom(a)) {
                    if (type instanceof ParameterizedType) {
                        return new q(value, this.a.c(an.a(0, (ParameterizedType) type), annotationArr), encoded).a();
                    }
                    throw a(i, a.getSimpleName() + " must include generic type (e.g., " + a.getSimpleName() + "<String>)", new Object[0]);
                } else if (!a.isArray()) {
                    return new q(value, this.a.c(type, annotationArr), encoded);
                } else {
                    return new q(value, this.a.c(al.a(a.getComponentType()), annotationArr), encoded).b();
                }
            }
            throw a(i, "@Field parameters can only be used with form encoding.", new Object[0]);
        } else if (annotation instanceof FieldMap) {
            if (this.o) {
                a = an.a(type);
                if (Map.class.isAssignableFrom(a)) {
                    b = an.b(type, a, Map.class);
                    if (b instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) b;
                        a2 = an.a(0, parameterizedType);
                        if (String.class != a2) {
                            throw a(i, "@FieldMap keys must be of type String: " + a2, new Object[0]);
                        }
                        c = this.a.c(an.a(1, parameterizedType), annotationArr);
                        this.g = true;
                        return new r(c, ((FieldMap) annotation).encoded());
                    }
                    throw a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw a(i, "@FieldMap parameter type must be Map.", new Object[0]);
            }
            throw a(i, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
        } else if (annotation instanceof Part) {
            if (this.p) {
                Part part = (Part) annotation;
                this.h = true;
                String value2 = part.value();
                a2 = an.a(type);
                if (!value2.isEmpty()) {
                    q a3 = q.a("Content-Disposition", "form-data; name=\"" + value2 + "\"", "Content-Transfer-Encoding", part.encoding());
                    if (Iterable.class.isAssignableFrom(a2)) {
                        if (type instanceof ParameterizedType) {
                            b = an.a(0, (ParameterizedType) type);
                            if (!y.class.isAssignableFrom(an.a(b))) {
                                return new u(a3, this.a.a(b, annotationArr, this.c)).a();
                            }
                            throw a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                        throw a(i, a2.getSimpleName() + " must include generic type (e.g., " + a2.getSimpleName() + "<String>)", new Object[0]);
                    } else if (a2.isArray()) {
                        b = al.a(a2.getComponentType());
                        if (!y.class.isAssignableFrom(b)) {
                            return new u(a3, this.a.a(b, annotationArr, this.c)).b();
                        }
                        throw a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    } else if (!y.class.isAssignableFrom(a2)) {
                        return new u(a3, this.a.a(type, annotationArr, this.c));
                    } else {
                        throw a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                } else if (Iterable.class.isAssignableFrom(a2)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw a(i, a2.getSimpleName() + " must include generic type (e.g., " + a2.getSimpleName() + "<String>)", new Object[0]);
                    } else if (y.class.isAssignableFrom(an.a(an.a(0, (ParameterizedType) type)))) {
                        return aa.a.a();
                    } else {
                        throw a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                } else if (a2.isArray()) {
                    if (y.class.isAssignableFrom(a2.getComponentType())) {
                        return aa.a.b();
                    }
                    throw a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                } else if (y.class.isAssignableFrom(a2)) {
                    return aa.a;
                } else {
                    throw a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
            }
            throw a(i, "@Part parameters can only be used with multipart encoding.", new Object[0]);
        } else if (annotation instanceof PartMap) {
            if (this.p) {
                this.h = true;
                a = an.a(type);
                if (Map.class.isAssignableFrom(a)) {
                    b = an.b(type, a, Map.class);
                    if (b instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) b;
                        a2 = an.a(0, parameterizedType);
                        if (String.class != a2) {
                            throw a(i, "@PartMap keys must be of type String: " + a2, new Object[0]);
                        }
                        b = an.a(1, parameterizedType);
                        if (!y.class.isAssignableFrom(an.a(b))) {
                            return new v(this.a.a(b, annotationArr, this.c), ((PartMap) annotation).encoding());
                        }
                        throw a(i, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                    }
                    throw a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                throw a(i, "@PartMap parameter type must be Map.", new Object[0]);
            }
            throw a(i, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
        } else if (!(annotation instanceof Body)) {
            return null;
        } else {
            if (this.o || this.p) {
                throw a(i, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
            } else if (this.i) {
                throw a(i, "Multiple @Body method annotations found.", new Object[0]);
            } else {
                try {
                    c = this.a.a(type, annotationArr, this.c);
                    this.i = true;
                    return new p(c);
                } catch (Throwable e) {
                    throw a(e, i, "Unable to create @Body converter for %s", type);
                }
            }
        }
    }

    private void a(int i, String str) {
        if (!al.b.matcher(str).matches()) {
            throw a(i, "@Path parameter name must match %s. Found: %s", al.a.pattern(), str);
        } else if (!this.t.contains(str)) {
            throw a(i, "URL \"%s\" does not contain \"{%s}\".", this.q, str);
        }
    }

    private void a(String str, String str2, boolean z) {
        if (this.m != null) {
            throw a("Only one HTTP method is allowed. Found: %s and %s.", this.m, str);
        }
        this.m = str;
        this.n = z;
        if (!str2.isEmpty()) {
            int indexOf = str2.indexOf(63);
            if (indexOf != -1 && indexOf < str2.length() - 1) {
                if (al.a.matcher(str2.substring(indexOf + 1)).find()) {
                    throw a("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", str2.substring(indexOf + 1));
                }
            }
            this.q = str2;
            this.t = al.a(str2);
        }
    }

    private void a(Annotation annotation) {
        if (annotation instanceof DELETE) {
            a("DELETE", ((DELETE) annotation).value(), false);
        } else if (annotation instanceof GET) {
            a("GET", ((GET) annotation).value(), false);
        } else if (annotation instanceof HEAD) {
            a("HEAD", ((HEAD) annotation).value(), false);
            if (!Void.class.equals(this.f)) {
                throw a("HEAD method must use Void as response type.", new Object[0]);
            }
        } else if (annotation instanceof PATCH) {
            a(HttpPatch.METHOD_NAME, ((PATCH) annotation).value(), true);
        } else if (annotation instanceof POST) {
            a("POST", ((POST) annotation).value(), true);
        } else if (annotation instanceof PUT) {
            a("PUT", ((PUT) annotation).value(), true);
        } else if (annotation instanceof OPTIONS) {
            a("OPTIONS", ((OPTIONS) annotation).value(), false);
        } else if (annotation instanceof HTTP) {
            HTTP http = (HTTP) annotation;
            a(http.method(), http.path(), http.hasBody());
        } else if (annotation instanceof Headers) {
            String[] value = ((Headers) annotation).value();
            if (value.length == 0) {
                throw a("@Headers annotation is empty.", new Object[0]);
            }
            this.r = a(value);
        } else if (annotation instanceof Multipart) {
            if (this.o) {
                throw a("Only one encoding annotation is allowed.", new Object[0]);
            }
            this.p = true;
        } else if (!(annotation instanceof FormUrlEncoded)) {
        } else {
            if (this.p) {
                throw a("Only one encoding annotation is allowed.", new Object[0]);
            }
            this.o = true;
        }
    }

    private CallAdapter<T, R> b() {
        Type genericReturnType = this.b.getGenericReturnType();
        if (an.d(genericReturnType)) {
            throw a("Method return type must not include a type variable or wildcard: %s", genericReturnType);
        } else if (genericReturnType == Void.TYPE) {
            throw a("Service methods cannot return void.", new Object[0]);
        } else {
            try {
                return this.a.a(genericReturnType, this.b.getAnnotations());
            } catch (Throwable e) {
                throw a(e, "Unable to create call adapter for %s", genericReturnType);
            }
        }
    }

    private Converter<ai, T> c() {
        try {
            return this.a.b(this.f, this.b.getAnnotations());
        } catch (Throwable e) {
            throw a(e, "Unable to create converter for %s", this.f);
        }
    }

    public al a() {
        this.w = b();
        this.f = this.w.responseType();
        if (this.f == ai.class || this.f == ag.class) {
            throw a("'" + an.a(this.f).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        }
        int i;
        this.v = c();
        for (Annotation a : this.c) {
            a(a);
        }
        if (this.m == null) {
            throw a("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        }
        if (!this.n) {
            if (this.p) {
                throw a("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
            } else if (this.o) {
                throw a("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
            }
        }
        int length = this.d.length;
        this.u = new o[length];
        for (i = 0; i < length; i++) {
            Type type = this.e[i];
            if (an.d(type)) {
                throw a(i, "Parameter type must not include a type variable or wildcard: %s", type);
            }
            Annotation[] annotationArr = this.d[i];
            if (annotationArr == null) {
                throw a(i, "No Retrofit annotation found.", new Object[0]);
            }
            this.u[i] = a(i, type, annotationArr);
        }
        if (this.q == null && !this.l) {
            throw a("Missing either @%s URL or @Url parameter.", this.m);
        } else if (!this.o && !this.p && !this.n && this.i) {
            throw a("Non-body HTTP method cannot contain @Body.", new Object[0]);
        } else if (this.o && !this.g) {
            throw a("Form-encoded method must contain at least one @Field.", new Object[0]);
        } else if (!this.p || this.h) {
            return new al(this);
        } else {
            throw a("Multipart method must contain at least one @Part.", new Object[0]);
        }
    }
}
