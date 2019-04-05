package ru.java.courses.sport.team.football;

abstract class AppearanceBuilder{
        protected Appearance appearence;

        public Appearance getAppearance() {return appearence; }
        public void createNewTeamAppearance() { appearence = new Appearance(); }

        public abstract void buildUniform_color();
        public abstract void buildFlag();
        public abstract void buildLogo();
}
