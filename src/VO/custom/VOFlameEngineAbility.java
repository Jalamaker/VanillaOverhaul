package VO.custom;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.math.Interp;
import arc.math.Mathf;
import arc.util.*;
import mindustry.Vars;
import mindustry.entities.Effect;
import mindustry.entities.abilities.Ability;
import mindustry.gen.Unit;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;

import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.lineAngle;
import static arc.graphics.g2d.Lines.stroke;
import static arc.math.Angles.randLenVectors;

public class VOFlameEngineAbility extends Ability{

    public float effectInterval = 3f;
    public float x, y, rotation, width, length;
    public int particles = 1;
    public boolean rotateEffect = false;
    public float effectParam = 3f;
    public boolean teamColor = true;
    public boolean parentizeEffects;
    public Color color = Color.white;

    public float lightStroke = 40f;
    public float oscScl = 1.2f, oscMag = 0.02f;
    public int divisions = 25;

    public boolean rotateFlare = false;
    public Interp lengthInterp = Interp.slope;

    public float[] lengthWidthPans = {
        1.12f, 1.3f, 0.32f,
        1f, 1f, 0.3f,
        0.8f, 0.9f, 0.2f,
        0.5f, 0.8f, 0.15f,
        0.25f, 0.7f, 0.1f,
    };

    protected float counter;

    public VOFlameEngineAbility(float x, float y, float width, float length, float rotation, float effectInterval, int particles){
        this.x = x; this.y = y;
        this.width = width;
        this.length = length;
        this.rotation = rotation;
        this.effectInterval = effectInterval;
        this.particles = particles;
        display = false;
    }

    @Override
    public void update(Unit unit){
        if(Vars.headless) return;

        counter += Time.delta;
        if((counter >= effectInterval) && !unit.inFogTo(Vars.player.team())){
            Tmp.v1.trns(unit.rotation - 90f, x, y);
            counter %= effectInterval;
            Effect effect = new Effect(30f, length * 2f, e -> {
                color(); stroke(e.fout() * (width / 5f));
                randLenVectors(e.id + 1, particles, (length / 3f) + length * e.finpow(), (x, y) -> {
                    lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1f + e.fout() * (length / 10f));
                });
            });
            effect.at(Tmp.v1.x + unit.x, Tmp.v1.y + unit.y, (rotateEffect ? unit.rotation : effectParam) + rotation, teamColor ? unit.team.color : color, parentizeEffects ? unit : null);
        }
    }  

    @Override
    public void draw(Unit unit){

        float sin = Mathf.sin(Time.time, oscScl, oscMag);

        Color[] colors = {unit.team.color.a(0.5f), unit.team.color.a(0.75f), unit.team.color, Color.white.cpy()};
        for(int i = 0; i < colors.length; i++){
            Draw.color(colors[i].write(Tmp.c1).mul(0.9f).mul(1f + Mathf.absin(Time.time, 1f, 0.1f)));
            Drawf.flame(Tmp.v1.x + unit.x, Tmp.v1.y + unit.y, divisions, rotation,
                length * lengthWidthPans[i * 3] * (1f - sin),
                width * lengthWidthPans[i * 3 + 1] * (1f + sin),
                lengthWidthPans[i * 3 + 2]
            );
        }

        Tmp.v1.trns(rotation, length * 1.1f);
        Drawf.light(unit.x + Tmp.v1.x, unit.y + Tmp.v1.y, lightStroke, Pal.powerLight, 0.3f);
        Draw.reset();
    }
}