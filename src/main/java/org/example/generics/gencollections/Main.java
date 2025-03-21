package org.example.generics.gencollections;

import org.example.generics.kotlins.BaseballTeam;

interface Player {
    String name();
}

record FootballPlayer(String name, String position) implements Player {
}

public class Main {

    public static void main(String[] args) {

//        var abc = new Affiliation("city", "YK", "ID");
//        BaseballTeam phillies1 = new BaseballTeam("Philadelphia Phillies");
//        BaseballTeam astros1 = new BaseballTeam("Houston Astros");
//        scoreResult(phillies1, 3, astros1, 5);
//
//        SportsTeam phillies2 = new SportsTeam("Philadelphia Phillies");
//        SportsTeam astros2 = new SportsTeam("Houston Astros");
//        scoreResult(phillies2, 3, astros2, 5);
//
//        Team<BaseballPlayer, Affiliation> phillies = new Team<>("Philadelphia Phillies", abc);
//        Team<FootballPlayer, Affiliation> astros = new Team<>("Houston Astros", abc);
//        scoreResult(phillies, 3, astros, 5);
//
//        var harper = new BaseballPlayer("B Harper", "Right Fielder");
//        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
//        phillies.addTeamMember(harper);
//        phillies.addTeamMember(marsh);
//        var guthrie = new BaseballPlayer("D Guthrie", "Center Fielder");
//        phillies.addTeamMember(guthrie);
//        phillies.listTeamMembers();
//
//        SportsTeam afc1 = new SportsTeam("Adelaide Crows");
//        Team<FootballPlayer, String> afc = new Team<>("Adelaide Crows", "dsa");
//        var tex = new FootballPlayer("Tex Walker", "Centre half forward");
//        afc.addTeamMember(tex);
//        var rory = new FootballPlayer("Rory Laird", "Midfield");
//        afc.addTeamMember(rory);
//        afc.listTeamMembers();


        var nationalUsPark = new Park[]{
                new Park("YStone", "44.111, -110.212"),
                new Park("Glowstone", "41.111, -100.212")
        };

//        Team<FootballPlayer , Affiliation> adelaide = new Team<>("Adelaide Storm");
//        adelaide.addTeamMember("N Roberts");
//        adelaide.listTeamMembers();

        Layer<Park> parkLayer = new Layer<>(nationalUsPark);
        parkLayer.renderLayer();

        var majorUsParkRiver = new River[]{
                new River("Ongordio", "22.111, -31.123"),
                new River("Glowsku", "21.2321,-11.132")
        };

        Layer<River> riverLayer = new Layer<>(majorUsParkRiver);
        riverLayer.addElements(
                new River("Ongordis", "19.111, -31.123"),
                new River("Glowskus", "10.2321,-11.132")
        );
        riverLayer.renderLayer();
    }

//    public static void scoreResult(BaseballTeam team1, int t1_score,
//                                   BaseballTeam team2, int t2_score) {
//
//        String message = team1.setScore(t1_score, t2_score);
//        team2.setScore(t2_score, t1_score);
//        System.out.printf("%s %s %s %n", team1, message, team2);
//    }
//
//    public static void scoreResult(SportsTeam team1, int t1_score,
//                                   SportsTeam team2, int t2_score) {
//
//        String message = team1.setScore(t1_score, t2_score);
//        team2.setScore(t2_score, t1_score);
//        System.out.printf("%s %s %s %n", team1, message, team2);
//    }
//
//    public static void scoreResult(Team team1, int t1_score,
//                                   Team team2, int t2_score) {
//
//        String message = team1.setScore(t1_score, t2_score);
//        team2.setScore(t2_score, t1_score);
//        System.out.printf("%s %s %s %n", team1, message, team2);
//    }
}
