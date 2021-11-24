package algorithmstransformation.family;

import java.util.ArrayList;
import java.util.List;

public class Family {

    private List<FamilyMember> familyMembers;

    public Family() {
        familyMembers = new ArrayList<>();
    }

    public List<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    public void addFamilyMember(FamilyMember familyMember) {
        familyMembers.add(familyMember);
    }

    public List<Integer> getAgesOfFamilyMembersWithNameGiven(String name) {
        List<Integer> agesWithName = new ArrayList<>();
        for (FamilyMember member : familyMembers) {
            if (member.getName().contains(name)) {
                agesWithName.add(member.getAge());
            }
        }
        return agesWithName;
    }

}
