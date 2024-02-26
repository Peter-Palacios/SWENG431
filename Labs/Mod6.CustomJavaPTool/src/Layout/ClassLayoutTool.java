package Layout;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.*;

public class ClassLayoutTool {

    public static void getClassInfo(String className) throws ClassNotFoundException {
        Class<?> classInfo = Class.forName(className);

        String classModifier = Modifier.toString(classInfo.getModifiers());

        System.out.println("Compiled from \"" + classInfo.getSimpleName() + ".java\"");
        System.out.println(classModifier + " " + classInfo.getName() + " {");

        for (Field field : classInfo.getDeclaredFields()) {
            System.out.println("  " + Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName() + ";");
        }

        for (Constructor<?> constructor : classInfo.getDeclaredConstructors()) {
            System.out.println("  " + simplifiedModifierAndType(constructor.getModifiers(), classInfo.getSimpleName()) + getParameterTypes(constructor.getParameters()) + ";");
        }

        for (Method method : classInfo.getDeclaredMethods()) {
            System.out.println("  " + simplifiedModifierAndType(method.getModifiers(), method.getReturnType().getSimpleName()) + " " + method.getName() + getParameterTypes(method.getParameters()) + getExceptionTypes(method) + ";");
        }

        System.out.println("}");
    }

    private static @NotNull String simplifiedModifierAndType(int modifiers, String typeName) {
        return Modifier.toString(modifiers) + (modifiers > 0 ? " " : "") + typeName;
    }

    private static @NotNull String getExceptionTypes(Method method) {
        Class<?>[] exceptionTypes = method.getExceptionTypes();
        if (exceptionTypes.length > 0) {
            StringBuilder exceptions = new StringBuilder(" throws ");
            for (int i = 0; i < exceptionTypes.length; i++) {
                if (i > 0) {
                    exceptions.append(", ");
                }
                exceptions.append(exceptionTypes[i].getCanonicalName());
            }
            return exceptions.toString();
        } else {
            return "";
        }
    }

    private static @NotNull String getParameterTypes(Parameter[] params) {
        StringBuilder parameters = new StringBuilder();
        parameters.append("(");
        for (int i = 0; i < params.length; i++) {
            if (i > 0) {
                parameters.append(", ");
            }
            parameters.append(params[i].getType().getTypeName());
            parameters.append(" ");
            parameters.append(params[i].getName());
        }
        parameters.append(")");
        return parameters.toString();
    }

    public static void main(String[] args) {
        try {
            getClassInfo("Layout.Rectangle");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
