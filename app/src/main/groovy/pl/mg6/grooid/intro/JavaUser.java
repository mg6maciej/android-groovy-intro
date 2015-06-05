package pl.mg6.grooid.intro;

import java.util.ArrayList;
import java.util.List;

public final class JavaUser {

    private final String name;
    private final List<JavaUser> friends;
    private final boolean isSuper;

    public JavaUser(String name, List<JavaUser> friends, boolean isSuper) {
        this.name = name;
        this.friends = friends;
        this.isSuper = isSuper;
    }

    static void something() {
        List<JavaUser> friends = new ArrayList<JavaUser>();
        friends.add(new JavaUser("Filomena", null, false));
        friends.add(new JavaUser("Maciej", null, true));
        JavaUser alek = new JavaUser("Alek", friends, true);

        List<String> superfriends = new ArrayList<String>();
        for (JavaUser friend : alek.friends) {
            if (friend.isSuper) {
                superfriends.add(friend.name);
            }
        }
    }
}
