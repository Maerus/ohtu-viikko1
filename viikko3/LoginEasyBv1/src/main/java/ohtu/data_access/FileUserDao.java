
package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ohtu.domain.User;
import org.springframework.stereotype.Component;

@Component
public class FileUserDao implements UserDao {
    
    private List<User> users;
    private File file;
    
    
    public FileUserDao(String filepath) {
        users = new ArrayList<User>();
        file = new File(filepath);
        Scanner s;
        try {
            s = new Scanner(file);
            while(s.hasNextLine()){
            String[] line = s.nextLine().split("\t");
            users.add(new User(line[0], line[1]));
        }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }

    @Override
    public List<User> listAll() {
        return users;
    }

    @Override
    public User findByName(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public void add(User user) {
        users.add(user);
        try {
            FileWriter fw = new FileWriter(file);
            int size = users.size();
            for (int i = 0 ; i < size ; i++) {
                if(i == size-1){
                    fw.write(users.get(i).getUsername() + "\t" + users.get(i).getPassword());
                } else {
                    fw.write(users.get(i).getUsername() + "\t" + users.get(i).getPassword() + "\n");
                }
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println("file not found");
        }
    }
    
    public void setUsers(List<User> users) {
        this.users = users;
    }

}
