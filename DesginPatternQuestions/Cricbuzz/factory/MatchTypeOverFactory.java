package Cricbuzz.factory;

import Cricbuzz.match.MatchType;

public class MatchTypeOverFactory {
    public int getNumberOfOversByType(MatchType type) {
        switch (type) {
            case T20:
                return 2;
            case ODI:
                return 5;
            case TEST:
                return 9;
            default:
                return 1;
        }
    }
}
